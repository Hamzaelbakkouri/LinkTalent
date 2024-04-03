'use client'
import React from 'react';
import { useForm, SubmitHandler } from 'react-hook-form';
import axios from 'axios';
import { toast } from 'react-toastify';

interface FormValues {
  firstname: string;
  lastname: string;
  email: string;
  address: string;
  password: string;
  phoneNumber: string;
  sportId: string;
}

const RegisterForm: React.FC = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormValues>();

  const onSubmit: SubmitHandler<FormValues> = async (data: FormValues) => {
    try {
      const response = await axios.post('http://localhost:8080/api/auth/register', data);
      console.log(response.data);
      toast.success('Registration successful!');
    } catch (error) {
      console.error(error);
      toast.error('Registration failed. Please try again.');
    }
  };

  return (
    <div className="w-full h-auto flex pt-9 justify-center items-center">
      <form onSubmit={handleSubmit(onSubmit)} className="bg-[#1E1F24] h-[55%] w-[50%]  rounded-md py-14 px-7 border border-gray-600 flex flex-col">
        <div className="flex flex-col justify-start w-full items-center">
          <h3 className="text-3xl font-bold uppercase text-[#45a3fce3] rounded-lg bg-[#1f2024]">Register</h3>
        </div>

        <div className="flex flex-col justify-center py-8">
          <div className="relative mb-4">
            <input
              type="text"
              id="firstname"
              {...register('firstname', {
                required: 'First name is required',
                maxLength: { value: 30, message: 'First name is too long' },
              })}
              className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
              placeholder="First Name"
            />
            {errors.firstname && <small className="absolute text-red-700 pl-2">{errors.firstname.message}</small>}
          </div>

          <div className="relative mb-4">
            <input
              type="text"
              id="lastname"
              {...register('lastname', {
                maxLength: { value: 30, message: 'Last name is too long' },
              })}
              className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
              placeholder="Last Name"
            />
            {errors.lastname && <small className="absolute text-red-700 pl-2">{errors.lastname.message}</small>}
          </div>

          <div className="relative mb-4">
            <input
              type="email"
              id="email"
              {...register('email', {
                required: 'Email is required',
                maxLength: { value: 80, message: 'Email is too long' },
                pattern: {
                  value: /^\S+@\S+\.\S+$/i,
                  message: 'Invalid email address',
                },
              })}
              className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
              placeholder="Email"
            />
            {errors.email && <small className="absolute text-red-700 pl-2">{errors.email.message}</small>}
          </div>

          <div className="relative mb-4">
            <input
              type="text"
              id="address"
              {...register('address', { required: 'Address is required' })}
              className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
              placeholder="Address"
            />
            {errors.address && <small className="absolute text-red-700 pl-2">{errors.address.message}</small>}
          </div>

          <div className="relative mb-4">
            <input
              type="password"
              id="password"
              {...register('password', {
                required: 'Password is required',
                minLength: { value: 8, message: 'Password is too short' },
              })}
              className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
              placeholder="Password"
            />
            {errors.password && <small className="absolute text-red-700 pl-2">{errors.password.message}</small>}
          </div>

          <div className="relative mb-4">
            <input
              type="tel"
              id="phoneNumber"
              {...register('phoneNumber', {
                required: 'Phone number is required',
                pattern: {
                  value: /^0\d{9}$/,
                  message: 'Invalid phone number format',
                },
              })}
              className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
              placeholder="Phone Number"
            />
            {errors.phoneNumber && <small className="absolute text-red-700 pl-2">{errors.phoneNumber.message}</small>}
          </div>

          <div className="relative mb-4">
            <select
              id="sportId"
              {...register('sportId', { required: 'Sport is required' })}
              className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
            >
              <option value="">Select Sport</option>
              <option value="c558a80a-f319-4c10-95d4-4282ef745b4b">FOOTBALL</option>
            </select>
            {errors.sportId && <small className="absolute text-red-700 pl-2">{errors.sportId.message}</small>}
          </div>
        </div>

        <button type="submit" className="relative flex justify-center uppercase cursor-pointer py-3 mt-4">
          <p className="px-12 py-3 bg-[#45a3fce3] hover:bg-[#33628de3] rounded-lg font-semibold">Register</p>
        </button>
      </form>
    </div>
  );
};

export default RegisterForm;