"use client"
import React, { useEffect } from 'react'
import { useParams } from 'next/navigation'
import Cookies from 'universal-cookie'
import { useRouter } from 'next/navigation'
import axios from 'axios'
import { toast } from 'react-toastify'
import { ApplyRequest, ApplyResponse } from '@/Types/Apply'
import { PROFILE } from '@/Types/UserTypes'

const page = () => {
    const cookie = new Cookies()
    const user: PROFILE = cookie.get('user')
    const token = cookie.get('token')
    const params = useParams()
    const router = useRouter()
    const [data, setData] = React.useState<ApplyResponse>()
    const fakeApply: ApplyRequest = {
        id: {
            announcement: {
                id: params.applyPage as string
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
                const response = await axios.get(`http://localhost:8080/api/apply/${params.applyPage}/${user.id}`, {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                })
                setData(response.data)
                response.data ? toast.info('You have already applied') : toast.info('You have not applied yet')
            } catch (error) {
                toast.error('Failed to fetch Application')
            }
        })()
    }, [])
    

    const apply = async () => {
        try {
            const response = await axios.post('http://localhost:8080/api/apply', fakeApply, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            })
            toast.success('Applied successfully')
            setData(response.data)
        } catch (error) {
            toast.error('Failed to apply')
            console.log(error)
        }
    }

    return (
        <div className='w-full flex justify-center'>
            <button onClick={apply}>Apply</button>
        </div>
    )
}

export default page
