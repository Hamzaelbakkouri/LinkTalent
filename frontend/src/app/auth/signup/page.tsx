'use client'
import { ContainerScroll } from '@/components/Home/container_animation_scroll';
import InputSign from '@/components/inputs/InputSign';
import { TextGenerateEffect } from '@/components/paragraph/TextGenerateEffect';
import React from 'react'
import { FaKey } from 'react-icons/fa';
import { MdEmail } from 'react-icons/md';

const register = () => {
  const paragraph = "Please provide your credentials to complete the sign-up process";
  let validation = "";

  function submitRegister(e: any) {
    e.preventDefault();
    if (validation == null) {
      validation = "this field is required"
    }
    console.log('submitting form');
  }

  return (
    <>
      <div className='w-full h-[90vh] flex justify-center items-center'>
        <form onSubmit={submitRegister} className='bg-[#1E1F24] h-[45%] w-[50%] rounded-md py-3 px-7 border border-gray-600 flex flex-col'>
          <div className='flex flex-col justify-start w-full items-center'>
            <h3 className='text-3xl font-bold uppercase text-[#45a3fce3] rounded-lg bg-[#1f2024]'>Sign Up</h3>
            <small className='text-lg p-5'><TextGenerateEffect className='text-[#848892]' words={paragraph} /></small>
          </div>
          <div className='flex justify-center pb-8 pt-3'>
            <div className="relative">
              <div className="absolute inset-y-0 start-0 flex items-center ps-7 pointer-events-none">
                <MdEmail className="w-4 h-4 text-gray-500 dark:text-gray-400" />
              </div>
              <input type="email" id="default-search" className="block w-full px-28 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50  dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white " placeholder="Email" required />
              <small className='absolute text-red-700 pl-2'>{validation}</small>
            </div>
          </div>
          <div className='flex justify-center'>
            <div className="relative">
              <div className="absolute inset-y-0 start-0 flex items-center ps-7 pointer-events-none">
                <FaKey className="w-4 h-4 text-gray-500 dark:text-gray-400" />
              </div>
              <input type="password" id="default-search" className="block w-full px-28 py-3 text-sm font-semibold text-gray-900 border border-gray-300 rounded-lg bg-gray-50  dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white " placeholder="Password" required />
              <small className='absolute text-red-700 pl-2'>{validation}</small>
            </div>
          </div>
          <InputSign icon={<FaKey className="w-4 h-4 text-gray-500 dark:text-gray-400" />} validation={validation} width={28} onChange={(e) => console.log(e.target.value)} />
          <button type='submit' className='relative flex justify-center uppercase cursor-pointer py-3 mt-4'>
            <p className='px-12 py-3 bg-[#45a3fce3] hover:bg-[#33628de3] rounded-lg font-semibold'>ENTER</p>
          </button>
        </form>
        
      </div>
    </>
  )
}

export default register
