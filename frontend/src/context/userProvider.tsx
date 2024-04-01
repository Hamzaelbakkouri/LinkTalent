'use client'
import { PROFILE } from "@/Types/UserTypes";
import { createContext, useContext, useState, useEffect } from "react";
import Cookies from "universal-cookie";
import axios from "axios";
import { useRouter } from "next/navigation";
import { toast } from "react-toastify";

interface AuthContext {
    state: PROFILE | any
    login: (email: string, password: string) => void;
}

export const AuthContext = createContext<AuthContext | null>(null);

export const AuthProvider: React.FC<React.PropsWithChildren> = ({ children }) => {
    const [state, setState] = useState<PROFILE | null>(null);
    const cookie = new Cookies();
    const router = useRouter();

    useEffect(() => {
        const token = cookie.get('token');
        const user = cookie.get('user');

        if (token && user) {
            setState(user);
        }
    }, []);

    const getTheCurrentUser = async (token: string) => {
        try {
            const response = await axios.get('http://localhost:8080/api/person/profile', {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            setState(response.data);
        } catch (error) {
            console.log(error);
        }
    };


    const login = async (email: string, password: string) => {
        await axios.post(`http://localhost:8080/api/auth`, {
            email,
            password
        }).then(async (res: any) => {
            await getTheCurrentUser(res.data.access_token)
            if (state) {
                cookie.get('token') && cookie.remove('token')
                cookie.set('token', res.data.access_token);
                cookie.set('user', state)
                router.push("/user");
                toast.success("Login successful!");
            } else {
                cookie.remove('token');
                cookie.remove('user')
                toast.error("Failed to login");
            }
            // redirection
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
