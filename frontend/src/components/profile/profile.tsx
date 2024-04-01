import React from 'react'
import { PROFILE } from '@/Types/UserTypes'

interface ProfileProps {
    profile: PROFILE
}
const profile: React.FC<ProfileProps> = ({ profile }) => {
    // function getRoleString(role: ROLE): string {
    //     switch (role) {
    //         case ROLE.PLAYER:
    //             return "Player";
    //         case ROLE.MANAGER:
    //             return "Manager";
    //         case ROLE.TEAMLEADER:
    //             return "Team Leader";
    //         case ROLE.ADMIN:
    //             return "Admin";
    //         default:
    //             return "Unknown";
    //     }
    // }
    return (
        <div>
            <div className="relative  mx-auto md:max-w-5xl min-w-0 break-words bg-[#1E1F24] w-full mb-6 shadow-lg rounded-xl mt-16">
                <div className="px-6">
                    <div className="flex flex-wrap justify-center">
                        <div className="w-full flex justify-center">
                            <div className="relative">
                                <img src="https://media.licdn.com/dms/image/D4E03AQFh9b7bS7j28A/profile-displayphoto-shrink_800_800/0/1677930776068?e=2147483647&v=beta&t=g5wcuEdHGlOczZ9-0svAVWC7EZGcaeYbCYoCZYdrg8U" className="shadow-xl rounded-full align-middle border-none absolute -m-16 -ml-20 lg:-ml-16 max-w-[150px]" />
                            </div>
                        </div>
                        <div className="w-full text-center mt-20">
                            <div className="flex justify-center lg:pt-4 pt-8 pb-0">
                                <div className="p-3 text-center">
                                    <span className="text-lg font-bold block tracking-wide text-white">{profile.role}</span>
                                    <span className="text-sm text-white">Status</span>
                                </div>
                                <div className="p-3 text-center">
                                    <span className="text-lg font-bold block uppercase tracking-wide text-white">{profile.email}</span>
                                    <span className="text-sm text-white">email</span>
                                </div>
                                <div className="p-3 text-center">
                                    <span className="text-lg font-bold block uppercase tracking-wide text-white">{profile.sport.name}</span>
                                    <span className="text-sm text-white">Sport</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="text-center mt-2">
                        <h3 className="text-2xl text-white font-bold leading-normal mb-1">{profile.firstName}  {profile.lastName}</h3>
                        <div className="text-xs mt-0 mb-2 text-white font-bold uppercase">
                            <i className="fas fa-map-marker-alt mr-2 text-white opacity-75"></i>{profile.address}
                        </div>
                    </div>
                    <div className="mt-6 py-6 border-slate-200 text-center">
                        <div className="flex flex-wrap justify-center">
                            <div className="w-full px-4">
                                <p className="font-light leading-relaxed text-gray-400 mb-4">
                                    {profile.firstName} is a person who holds the role of {profile.role}.
                                </p>
                                <p className="font-light leading-relaxed text-gray-400 mb-4">
                                    Email: {profile.email}
                                </p>
                                <p className="font-light leading-relaxed text-gray-400 mb-4">
                                    Phone: {profile.phoneNumber}
                                </p>
                                <p className="font-light leading-relaxed text-gray-400 mb-4">
                                    Address: {profile.address}
                                </p>
                                <a href="" className="font-normal text-gray-400 hover:text-white">Follow Account</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default profile