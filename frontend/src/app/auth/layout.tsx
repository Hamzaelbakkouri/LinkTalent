import Navbar from "@/components/user/Navbar";

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
                    <div>
                        {children}
                    </div>
                </div>
            </body>
        </html>
    );
}