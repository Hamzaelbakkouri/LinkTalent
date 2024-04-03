'use client'
import React from 'react'
import Profile from '@/components/profile/profile'
import Cookies from 'universal-cookie'
import Link from 'next/link'

const page = () => {
  const cookie = new Cookies();
  const userData = cookie.get('user');
  return (
    <div className='pt-5'>
      {userData && <Profile profile={userData} />}
      {userData.role === 'TEAMLEADER' ?
        <div className='w-full flex justify-center items-center'>
          <Link href="/leader/announcement/create" className='text-lg bg-[#1a385f] px-3 rounded-md py-2 hover:bg-[#264977] text-center'>create Announcement</Link>
        </div>
        :
        ""
      }
    </div>
  )
}

export default page
