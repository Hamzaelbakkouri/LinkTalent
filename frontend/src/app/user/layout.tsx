import Navbar from "@/components/user/Navbar";

export default function UserLayout({
    children,
}: Readonly<{
    children: React.ReactNode;
}>) {
    return (
        <html lang="en">
            <body>
                <div className="w-full grid grid-cols-6">
                    <div className="bg-red-500 col-span-1 h-screen">
                        hh
                    </div>
                    <div className="col-span-5">
                        <Navbar />
                        {children}
                    </div>
                </div>
            </body>
        </html>
    );
}