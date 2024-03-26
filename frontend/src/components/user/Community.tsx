import React from 'react'
import NotifCount from '../layouts/NotifCount'
import { GoPerson } from "react-icons/go";
import Image from 'next/image'

export type community = {
    userName: String
    tag: String
}


type props = {
    community: community[]
}
const Community: React.FC<props> = ({ community }) => {
    return (
        <div className='w-full'>
            <div className='flex justify-between p-2 pl-4 pb-4 items-center'>
                <p className='text-gray-200 '>My Community</p>
                <NotifCount width={16} number={120} icon={<GoPerson className='text-gray-300' />} />
            </div>
            <div className='w-full grid gap-y-9'>
                {community?.map((data, idx) => {
                    return (
                        <div key={idx} className='flex justify-start pl-7 items-center gap-3 cursor-pointer'>
                            <Image src={"/assets/logo_dark.png"} className='bg-gray-500 rounded-full py-1' width={50} height={50} alt='...' />
                            <div>
                                <p className='text-gray-200 hover:text-[#45a3fce3]'>{data.userName}</p>
                                <p className='text-gray-400 text-xs hover:text-[#45a3fce3]'>@{data.tag}</p>
                            </div>
                        </div>
                    )
                })}

            </div>
        </div>
    )
}

export default Community
