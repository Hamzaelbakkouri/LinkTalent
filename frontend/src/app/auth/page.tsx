"use client";
import React, { useState } from 'react';
import { MdEmail } from "react-icons/md";
import { FaKey } from "react-icons/fa";
import { TextGenerateEffect } from '@/components/paragraph/TextGenerateEffect';
import { useAuth } from '@/context/userProvider';

require('dotenv').config();

const Page = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const auth = useAuth();

  const paragraph = "Kindly input your credentials in order to proceed with the login";

  function validateForm() {
    let isValid = true;

    if (!email || !email.includes('@')) {
      setEmailError('Please enter a valid email address');
      isValid = false;
    } else {
      setEmailError('');
    }

    if (!password || password.length < 6) {
      setPasswordError('Password must be at least 6 characters long');
      isValid = false;
    } else {
      setPasswordError('');
    }

    return isValid;
  }

  function submitForm(e: any) {
    e.preventDefault();
    console.log();
    if (validateForm()) {
      auth?.login(email, password);
    }
  }

  return (
    <div className='w-full h-[90vh] flex justify-center items-center'>
      <form onSubmit={submitForm} className='bg-[#1E1F24] h-[55%] w-[50%] rounded-md py-14 px-7 border border-gray-600 flex flex-col'>
        <div className='flex flex-col justify-start w-full items-center'>
          <h3 className='text-3xl font-bold uppercase text-[#45a3fce3] rounded-lg bg-[#1f2024]'>Sign In</h3>
          <small className='text-lg p-5'><TextGenerateEffect className='text-[#848892]' words={paragraph} /></small>
        </div>
        <div className='flex justify-center pb-8 pt-3'>
          <div className="relative">
            <div className="absolute inset-y-0 start-0 flex items-center ps-7 pointer-events-none">
              <MdEmail className="w-4 h-4 text-gray-500 dark:text-gray-400" />
            </div>
            <input type="email" id="default-search" value={email} onChange={(e) => setEmail(e.target.value)} className="block w-full px-28 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50  dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white " placeholder="Email" />
            <small className='absolute text-red-700 pl-2'>{emailError}</small>
          </div>
        </div>
        <div className='flex justify-center'>
          <div className="relative">
            <div className="absolute inset-y-0 start-0 flex items-center ps-7 pointer-events-none">
              <FaKey className="w-4 h-4 text-gray-500 dark:text-gray-400" />
            </div>
            <input type="password" id="default-search" value={password} onChange={(e) => setPassword(e.target.value)} className="block w-full px-28 py-3 text-sm font-semibold text-gray-900 border border-gray-300 rounded-lg bg-gray-50  dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white " placeholder="Password" />
            <small className='absolute text-red-700 pl-2'>{passwordError}</small>
          </div>
        </div>
        <button type='submit' className='relative flex justify-center uppercase cursor-pointer py-3 mt-4'>
          <p className='px-12 py-3 bg-[#45a3fce3] hover:bg-[#33628de3] rounded-lg font-semibold'>ENTER</p>
        </button>
      </form>
    </div>
  );
};

export default Page;
