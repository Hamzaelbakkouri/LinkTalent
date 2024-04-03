'use client'
import React, { FC, useEffect } from 'react'
import Cookies from 'universal-cookie'
import axios from 'axios'
import { toast } from 'react-toastify'
import { ApplyRequest, ApplyResponse } from '@/Types/Apply'
import { PROFILE } from '@/Types/UserTypes'


interface Props {
    announcementId: string
    setOppen: any
}

const index: FC<Props> = ({ announcementId, setOppen }) => {
    const cookie = new Cookies()
    const user: PROFILE = cookie.get('user')
    const token = cookie.get('token')
    const [data, setData] = React.useState<ApplyResponse>()
    const [letter, setLetter] = React.useState<string>('')
    const fakeApply: ApplyRequest = {
        id: {
            announcement: {
                id: announcementId
            },
            player: {
                id: user.id
            }
        },
        fileType: "PDF",
        letter: "aloo"
    }
    useEffect(() => {
        (async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/apply/${announcementId}/${user.id}`, {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                })
                setData(response.data)
                response.data ? toast.info('You have already applied') : toast.info('You have not applied yet')
            } catch (error) {
                toast.success('You can apply now')
            }
        })()
    }, [])


    const apply = async () => {
        try {
            const response = await axios.post('http://localhost:8080/api/apply', {
                id: {
                    announcement: {
                        id: announcementId
                    },
                    player: {
                        id: user.id
                    }
                },
                fileType: "PDF",
                letter: letter
            }, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            })
            toast.success('Applied successfully')
            setData(response.data)
        } catch (error) {
            toast.error('Failed to apply')

        }
    }

    return (
        <>
            {data ?
                <div className='w-full h-screen flex justify-center items-center animate-pulse'>
                    <p onClick={()=>{setOppen(false)}} className='text-2xl bg-gray-600 p-9 rounded-lg'>Already Applied</p>
                </div>
                :
                <div>
                    <div className="fixed top-[30%] right-[30%] transform overflow-hidden rounded-lg bg-[#1E1F24] px-4 pt-5 pb-4 text-left shadow-xl transition-all sm:my-8 sm:w-full sm:max-w-lg sm:p-6">
                        <div>
                            <div className="mt-3 text-center sm:mt-5">
                                <h3 className="text-lg font-medium leading-6 text-white">
                                    Confirm your application
                                </h3>
                                <div className="mt-2">
                                    <p className="text-sm text-gray-500">
                                        Are you sure you want to apply for this announcement?
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div className="mt-5 sm:mt-6">
                            <div className='pb-4'>
                                <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">URL</label>
                                <input type="url" id="website" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="url.com" required />
                            </div>
                        </div>
                        <div className="mt-5 sm:mt-6 sm:grid sm:grid-flow-row-dense sm:grid-cols-2 sm:gap-3">
                            <button
                                type="button"
                                onClick={apply}
                                className="inline-flex w-full justify-center rounded-md border border-transparent bg-indigo-600 px-4 py-2 text-base font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 sm:col-start-2 sm:text-sm"
                            >
                                Apply
                            </button>
                            <button
                                onClick={() => { setOppen(false) }}
                                type="button"
                                className="mt-3 inline-flex w-full justify-center rounded-md border border-gray-300 bg-white px-4 py-2 text-base font-medium text-gray-700 shadow-sm hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 sm:col-start-1 sm:mt-0 sm:text-sm"
                            >
                                Cancel
                            </button>
                        </div>
                    </div>
                </div>

            }
        </>
    )
}

export default index
