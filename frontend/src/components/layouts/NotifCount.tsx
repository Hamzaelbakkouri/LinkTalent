import React from 'react';
import { GoPerson } from "react-icons/go";

type Props = {
    number: number;
    width: number;
    icon ?: any;
}

const NotifCount: React.FC<Props> = ({ number , width , icon}) => {
    return (
        <div className={`w-${width} py-1 bg-[#000000] border border-gray-600 rounded-full flex justify-center items-center`}>
            <p className='text-gray-300 text-sm flex items-center gap-1'>{icon}{number}</p>
        </div>
    );
}

export default NotifCount;