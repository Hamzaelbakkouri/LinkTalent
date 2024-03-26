"use client";
import Link from "next/link";
import { TypewriterEffectSmooth } from "../ui/typewriter-effect";
export function LandingTitle() {
    const words = [
        {
            text: "Find",
        },
        {
            text: "Best",
        },
        {
            text: "Opportunities",
        },
        {
            text: "with",
        },
        {
            text: "LinkTalent.",
            className: "text-blue-500 dark:text-blue-500",
        },
    ];
    return (
        <div className="flex flex-col items-center justify-center h-[40rem]  ">
            <p className="text-neutral-600 dark:text-neutral-200 text-xs sm:text-base  ">
                The Road To Success Starts Here!
            </p>
            <TypewriterEffectSmooth words={words} />
            <div className="flex flex-col md:flex-row space-y-4 md:space-y-0 space-x-0 md:space-x-4">
                <Link href='/auth' className="w-40 h-10 rounded-md flex justify-center items-center bg-black border dark:border-white border-transparent text-white text-sm">
                    Join now
                </Link>
                <Link href='/auth/signup' className="w-40 h-10 rounded-md flex justify-center items-center bg-white text-black border border-black  text-sm">
                    Signup
                </Link>
            </div>
        </div>
    );
}
