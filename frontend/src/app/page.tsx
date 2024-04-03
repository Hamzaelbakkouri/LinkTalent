'use client'
import { Globe } from "@/components/Globe";
import Navbar from "@/components/user/Navbar";
export default function Home() {
  return (
    <main className="flex flex-col h-screen">
      <Navbar />
      <Globe />
    </main>
  );
}