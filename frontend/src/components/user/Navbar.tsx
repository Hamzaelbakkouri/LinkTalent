import Link from 'next/link';
import React from 'react'
import { GoHomeFill } from "react-icons/go";
import { IoChatbubbleEllipses, IoNotifications } from "react-icons/io5";


const Navbar = () => {
    return (
        <>
            <div className='w-full bg-[#1E1F24] h-[9%] border border-l-gray-900 border-r-gray-900 border-t-gray-900 border-b-gray-600 flex justify-between items-center'>
                {/* First section */}
                <div className='flex justify-between items-center w-[50%]'>
                    <div className='flex items-center'>
                        <GoHomeFill className='text-gray-300 text-2xl ml-4' />
                        <p className='text-gray-200 text-lg ml-2'>Home</p>
                    </div>
                    <div className='flex items-center bg-[#27292F] rounded-md px-2 py-1 border border-gray-600 gap-2'>
                        <div className='bg-[#27292F] cursor-pointer hover:text-[#45a3fce3] hover:bg-[#33353D] rounded-md py-2 px-7 flex text-sm hover:border hover:border-gray-600'>
                            <p>Explore</p>
                        </div>
                        <div className='bg-[#27292F] cursor-pointer hover:text-[#45a3fce3] hover:bg-[#33353D] rounded-md py-2 px-7 flex text-sm hover:border hover:border-gray-600'>
                            <p>Community feed</p>
                        </div>
                        <div className='bg-[#27292F] cursor-pointer hover:text-[#45a3fce3] hover:bg-[#33353D] rounded-md py-2 px-8 flex text-sm items-center gap-3 hover:border hover:border-gray-600'>
                            <p>Mutual Friend</p>
                        </div>
                    </div>
                </div>

                {/* seconds section */}
                <div className='w-[50%] flex justify-end items-center'>
                    <IoChatbubbleEllipses className='text-gray-300 text-2xl mr-4  cursor-pointer' />
                    <IoNotifications className='text-gray-300 text-2xl mr-4 cursor-pointer' />
                    <div className='flex gap-3'>
                        <Link href="/profile" className='bg-[#27292F] hover:bg-[#33353D] hover:text-[#45a3fce3] border border-gray-600 rounded-md py-2 px-7 flex text-sm'>
                            <p>Profile</p>
                        </Link>
                        <Link href="/logout" className='bg-[#27292F] hover:bg-[#33353D] hover:text-[#45a3fce3] rounded-md border border-gray-600 py-2 px-7 mr-2 flex text-sm'>
                            <p>Logout</p>
                        </Link>
                        <Link href="/auth" className='bg-[#27292F] hover:bg-[#33353D] hover:text-[#45a3fce3] rounded-md border border-gray-600 py-2 px-7 mr-2 flex text-sm'>
                            <p>SignIn</p>
                        </Link>
                        <Link href="/auth/signup" className='bg-[#27292F] hover:bg-[#33353D] hover:text-[#45a3fce3] rounded-md border border-gray-600 py-2 px-7 mr-2 flex text-sm'>
                            <p>SignUp</p>
                        </Link>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Navbar
