'use client'
import React, { useEffect } from 'react'
import Profile from '@/components/profile/profile'
import { useAuth } from '@/context/userProvider'
import Cookies from 'universal-cookie'

const page = () => {
  const cookie = new Cookies();
  const userData = cookie.get('user');
  return (
    <div className='pt-5'>
      {userData && <Profile profile={userData} />}
    </div>
  )
}

export default page
