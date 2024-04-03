'use client'
import "./globals.css";
import { AuthProvider } from "@/context/userProvider";
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';
import { useRouter } from "next/navigation";
import { useLayoutEffect } from "react";
import Cookies from "universal-cookie";


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  const cookie = new Cookies();
  const route = useRouter();

  // useLayoutEffect(() => {
  //   if (!cookie.get('user')) {
  //     route.push("/auth");
  //   }
  // }, [])
  return (
    <html lang="en">
      <body>
        <AuthProvider>
          {children}
          <ToastContainer />
        </AuthProvider>
      </body>
    </html>
  );
}
