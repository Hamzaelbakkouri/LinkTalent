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