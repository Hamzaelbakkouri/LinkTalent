import Image from 'next/image'
import { GoHomeFill } from "react-icons/go";
import { IoShareSocialOutline } from "react-icons/io5";
import { SiSocialblade } from "react-icons/si";
import { IoMdChatbubbles } from "react-icons/io";
import Community, { community } from './Community';

const Sidebar = () => {
    const yourCommunityData: community[] = [
        { userName: "Hamza_el_bakkouri", tag: "elbakkourihamza" },
        { userName: "Allo_Wach", tag: "allo" },
    ];
    return (
        <>
            <div className="bg-[#1E1F24] h-screen border border-l-gray-900 border-b-gray-900 border-t-gray-900 border-r-gray-600">

                <div className='logo flex items-center gap-6 justify-start pl-4 pt-4'>
                    <div className=''>
                        <Image className='bg-[#2583FF] rounded-s-full' src="/assets/logo_white.png" alt="logo" width={80} height={80} />
                    </div>
                    <p className='font-semibold py-4 text-2xl text-[#45a3fce3] flex flex-col justify-center items-center'>LINKTALENT</p>
                </div>

                <div className='flex justify-center py-8'>
                    <div className="relative">
                        <div className="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                            <svg className="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                            </svg>
                        </div>
                        <input type="search" id="default-search" className="block w-full px-10 py-3 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50  dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white " placeholder="Explore More ..." required />
                    </div>
                </div>

                <div className='p-4 grid gap-y-2'>
                    <div className="relative cursor-pointer">
                        <div className="absolute inset-y-0 start-0 flex items-center ps-3 hover:text-[#2d99ffe3]">
                            <GoHomeFill className='text-3xl text-gray-400 hover:text-[#2d99ffe3]' />
                        </div>
                        <div className="w-full px-16 py-3 text-gray-900 rounded-lg bg-gray-600  dark:bg-[#1E1F24] font-semibold text-md hover:dark:bg-[#31333a] dark:placeholder-gray-400 dark:text-gray-400 hover:text-[#2d99ffe3] ">
                            Home
                        </div>
                    </div>
                    <div className="relative cursor-pointer">
                        <div className="absolute inset-y-0 start-0 flex items-center ps-3 hover:text-[#2d99ffe3]">
                            <IoShareSocialOutline className='text-3xl text-gray-400 hover:text-[#2d99ffe3]' />
                        </div>
                        <div className="w-full px-16 py-3 text-gray-900 rounded-lg bg-gray-50  dark:bg-[#1E1F24] font-semibold text-md hover:dark:bg-[#31333a] dark:placeholder-gray-400 dark:text-gray-400 hover:text-[#2d99ffe3] ">
                            Opportunities
                        </div>
                    </div>
                    <div className="relative cursor-pointer">
                        <div className="absolute inset-y-0 start-0 flex items-center ps-3 hover:text-[#2d99ffe3]">
                            <SiSocialblade className='text-3xl text-gray-400 hover:text-[#2d99ffe3]' />
                        </div>
                        <div className="w-full px-16 py-3 text-gray-900 rounded-lg bg-gray-50  dark:bg-[#1E1F24] font-semibold text-md hover:dark:bg-[#31333a] dark:placeholder-gray-400 dark:text-gray-400 hover:text-[#2d99ffe3] ">
                            Applies
                        </div>
                    </div>
                    <div className="relative cursor-pointer">
                        <div className="absolute inset-y-0 start-0 flex items-center ps-3 hover:text-[#2d99ffe3]">
                            <IoMdChatbubbles className='text-3xl text-gray-400 hover:text-[#2d99ffe3]' />
                        </div>
                        <div className="w-full px-16 py-3 text-gray-900 rounded-lg bg-gray-50  dark:bg-[#1E1F24] font-semibold text-md hover:dark:bg-[#31333a] dark:placeholder-gray-400 dark:text-gray-400 hover:text-[#2d99ffe3] ">
                            Chats
                        </div>
                    </div>
                </div>


                <div className='w-full flex justify-center py-6'>
                    <hr className='w-[80%] border-1 rounded-xl border-gray-700' />
                </div>

                <Community community={yourCommunityData} />

                <div className='w-full flex justify-center py-6'>
                    <hr className='w-[80%] border-1 rounded-xl border-gray-700' />
                </div>

            </div>
        </>
    )
}

export default Sidebar
