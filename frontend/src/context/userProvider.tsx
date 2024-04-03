'use client'
import { PROFILE } from "@/Types/UserTypes";
import { createContext, useContext, useState, useEffect } from "react";
import Cookies from "universal-cookie";
import axios from "axios";
import { useRouter } from "next/navigation";
import { toast } from "react-toastify";

interface AuthContext {
    state: PROFILE | null;
    login: (email: string, password: string) => void;
}

export const AuthContext = createContext<AuthContext | null>(null);

export const AuthProvider: React.FC<React.PropsWithChildren> = ({ children }) => {
    const cookie = new Cookies();
    const router = useRouter();
    const [state, setState] = useState<PROFILE | null>(cookie.get('user'));

    async function getTheCurrentUser(token: string): Promise<PROFILE> {
        try {
            const response = await axios.get('http://localhost:8080/api/person/profile', {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            return response.data;
        } catch (error) {
            throw error;
        }
    };


    const login = async (email: string, password: string) => {
        await axios.post(`http://localhost:8080/api/auth`, {
            email,
            password
        }).then(async (res: any) => {
            cookie.remove('token');
            cookie.set('token', res.data.access_token);
            toast.success("Login successful!");
            const user = await getTheCurrentUser(res.data.access_token)
            if (user) {
                cookie.remove('user')
                cookie.set('user', user)
                router.push("/user/announcement");
            } else {
                toast.error("Failed to login");
            }
        }).catch((err: any) => {
            console.log(err.response.data.message);
        })
    }

    return (
        <AuthContext.Provider value={{ state, login }}>
            {children}
        </AuthContext.Provider>
    );
}

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error('useAuth must be used within an AuthProvider');
    }
    return context;
}
