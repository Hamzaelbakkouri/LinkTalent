"use client";
import { USERFORMAT } from "@/Types/UserTypes";
import { createContext, useContext, useState, useEffect } from "react";
import Cookie from "universal-cookie";
import axios from "axios";

interface AuthContext {
    user: USERFORMAT | null;
    login: (email: string, password: string) => void;
}

export const AuthContext = createContext<AuthContext | null>(null);

export const AuthProvider: React.FC<React.PropsWithChildren> = ({ children }) => {
    const [user, setUser] = useState<USERFORMAT | null>(null);
    const Cookies = new Cookie();


    const getTheCurrentUser = async (token: string) => {
        try {
            const response = await axios.get('http://localhost:8080/api/person/profile', {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            setUser(response.data);
        } catch (error) {
            console.log(error);
        }
    };


    const login = async (email: string, password: string) => {
        await axios.post(`http://localhost:8080/api/auth`, {
            email,
            password
        }).then((res: any) => {
            console.log(res.data.access_token)
            getTheCurrentUser(res.data.access_token)
            if (user) {
                console.log(user);
                Cookies.set('token', res.data.access_token);
            }
            // Cookies.remove('token');
            // console.log("Failed to login");
            // redirection
        }).catch((err: any) => {
            console.log(err);
        });
    }

    return (
        <AuthContext.Provider value={{ user, login }}>
            {children}
        </AuthContext.Provider>
    );
}

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error("useAuth must be used within an AuthProvider");
    }
    return context;
}