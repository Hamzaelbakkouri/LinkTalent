import React, { useEffect, useState } from 'react'
import Post from './post'
import axios from 'axios';
import { Announcement } from '@/Types/Announcement';
import Cookies from 'universal-cookie';
import { toast } from "react-toastify"

export type PostType = {
  id: number;
  title: string;
  content: string;
}

const AnnouncementPage = () => {
  const [Page, setPage] = useState<number>(0);
  const [size, setSize] = useState<number>(5);
  const [data, setData] = useState<Announcement[]>();
  const [count, setCount] = useState();

  useEffect(() => {
    const cookie = new Cookies();
    (async () => {
      await axios.get(`http://localhost:8080/api/announcement?page=${Page}&size=${size}`, {
        headers: {
          Authorization: `Bearer ${cookie.get("token")}`
        }
      })
        .then(async ({ data }) => {
          setData(await data.content);
          setCount(await data.totalPages)
        })
        .catch((err: Error) => {
          toast.error(err.message)
        })
    })()
  }, [Page])
  return (
    <div className=''>
      <div className='flex justify-center items-center p-6 gap-5'>
        <button onClick={() => { Page != 0 && setPage(Page - 1) }} className='bg-[#1a385f] px-3 rounded-md py-2 hover:bg-[#264977] text-center'>previous</button>
        <button onClick={() => { Page + 1 != count && setPage(Page + 1) }} className='bg-[#1a385f] px-3 rounded-md py-2 hover:bg-[#264977] text-center'>next</button>
      </div>
      {data?.map((data: Announcement, idx: number) => {
        return (
          <>
            <Post key={idx} announcement={data} />
          </>
        )
      })}
    </div>
  )
}

export default AnnouncementPage