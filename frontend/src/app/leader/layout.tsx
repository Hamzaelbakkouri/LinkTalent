'use client'
import Navbar from "@/components/user/Navbar";
import Sidebar from "@/components/user/Sidebar";
import { useRouter } from "next/navigation";
import { useEffect, useLayoutEffect } from "react";
import Cookies from "universal-cookie";

export default function LeaderLayout({
    children,
}: Readonly<{
    children: React.ReactNode;
}>) {
    const cookie = new Cookies();
  const route = useRouter();

  useLayoutEffect(() => {
    const user = cookie.get('user');
    if (!user && user.role !== 'TEAMLEADER') {
      route.push("/auth");
    }
  }, [])
    return (
        <html lang="en">
            <body>
                <div className="w-full grid grid-cols-6">
                    <div className="h-screen fixed top-0 left-0">
                        <Sidebar />
                    </div>
                    <div className="col-span-6 ml-[14.5%]">
                        <Navbar />
                        {children}
                    </div>
                </div>
            </body>
        </html>
    );
}