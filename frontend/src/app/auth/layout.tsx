import Navbar from "@/components/user/Navbar";
import Sidebar from "@/components/user/Sidebar";

export default function UserLayout({
    children,
}: Readonly<{
    children: React.ReactNode;
}>) {
    return (
        <html lang="en">
            <body>
                <div className="w-full h-screen">
                        <Navbar />
                    <div className="">
                        {children}
                    </div>
                </div>
            </body>
        </html>
    );
}