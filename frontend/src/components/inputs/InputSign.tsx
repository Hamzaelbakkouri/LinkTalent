import React, { FC, ReactNode } from 'react'
import { FaKey } from 'react-icons/fa'

type InputType = {
    icon: ReactNode,
    validation: string,
    width: number,
    onChange?: (e?: any) => void | any
}

const InputSign: FC<InputType> = ({ icon, validation, width, onChange }) => {
    return (
        <>
            <div className='flex justify-center'>
                <div className="relative">
                    <div className="absolute inset-y-0 start-0 flex items-center ps-7 pointer-events-none">
                        {icon}
                        {/* <FaKey className="w-4 h-4 text-gray-500 dark:text-gray-400" /> */}
                    </div>
                    <input onChange={onChange} type="text" id="default-search" className={`block w-full px-${width} py-3 text-sm font-semibold text-gray-900 border border-gray-300 rounded-lg bg-gray-50  dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white `} placeholder="Password" required />
                    <small className='absolute text-red-700 pl-2'>{validation}</small>
                </div>
            </div>
        </>
    )
}

export default InputSign
