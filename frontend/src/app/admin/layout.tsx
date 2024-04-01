'use client'
import Navbar from "@/components/user/Navbar";
import Sidebar from "@/components/admin/sidebar";
import Cookies from "universal-cookie";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";

export default function AdminLayout({
    children,
}: Readonly<{
    children: React.ReactNode;
}>) {
    const cookie = new Cookies();
    const [Cookie, setCookie] = useState();
    const router = useRouter();

    useEffect(() => {
        (async () => {
            setCookie(await cookie.get("token"))
            if (!Cookie) {
                router.push("/auth");
            }
        })()
    }, [])
    return (
        <html lang="en">
            <body>
                <div className="w-full grid grid-cols-6">
                    <div className="h-screen fixed top-0 left-0">
                        <Navbar />
                        <Sidebar />
                    </div>
                    <div className="col-span-6 ml-[11%]">
                        <div>
                            {children}
                        </div>
                    </div>
                </div>
            </body>
        </html>
    );
}