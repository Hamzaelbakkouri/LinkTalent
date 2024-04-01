import { Announcement } from '@/Types/Announcement'
import Link from 'next/link'
import React from 'react'

interface announcementPost {
    announcement: Announcement
}

const post: React.FC<announcementPost> = ({ announcement }) => {
    return (
        <>
            <main className="h-full w-full bg-[#2A2A2C] flex items-center justify-center py-8">
                <div className="max-w-screen-md bg-[#1e1e20] mt-6 rounded-md p-4">
                    <div className="flex items-center justify-between">
                        <div className="gap-3.5	flex items-center ">
                            <img src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png" className="object-cover bg-yellow-500 rounded-full w-10 h-10" />
                            <div className="flex flex-col">
                                <b className="mb-2 capitalize">{announcement.team.name}</b>
                                <time dateTime="06-08-21" className="text-gray-400 text-xs">{announcement.creationDate}
                                </time>
                            </div>
                        </div>
                        <div className="rounded-full h-3.5 flex	items-center justify-center">
                            <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="34px" fill="#92929D">
                                <path d="M0 0h24v24H0V0z" fill="none" />
                                <path
                                    d="M6 10c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm12 0c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm-6 0c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z" />
                            </svg>
                        </div>
                    </div>

                    <div className="whitespace-pre-wrap mt-7">{announcement.title}</div>

                    <div className="mt-5 flex gap-2	w-full justify-center border-b pb-4 flex-col">
                        {announcement.team.sport.category == "TEAM"
                            ?
                            <img src="https://d1s9j44aio5gjs.cloudfront.net/2021/08/web-1200x675-1320x743.jpg" className="w-full rounded-lg object-cover h-96" alt="photo" />
                            :
                            <img src="https://www.wanneroo.wa.gov.au/images/kingsway_futsal_feb2023_tile.png" className="w-full rounded-lg object-cover h-96" alt="photo" />
                        }
                        <div className='w-full'>
                            This Announcement for the {announcement.team.sport.category} category
                        </div>
                        <div className='w-full flex flex-col text-gray-400'>
                            description : {announcement.description}
                            <a className='text-blue-300 hover:text-blue-400' href={announcement.link}>Link : {announcement.link}</a>
                        </div>
                    </div>
                    <div className=" h-16 flex items-center justify-around ">
                        <div className="flex items-center gap-3">
                            <Link href={`/user/apply/${announcement.id}`} className="text-sm hover:bg-[#363636] px-11 py-2 rounded-md">Apply</Link>
                        </div>
                        <div className="flex items-center gap-3">
                            <button className="text-sm hover:bg-[#363636] px-11 py-2 rounded-md">Share</button>
                        </div>
                    </div>
                </div>
            </main>
        </>
    )
}

export default post