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
  const cookie = new Cookies();

  useEffect(() => {
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
  }, [])
  return (
    <div className=''>
      {data?.map((data: Announcement, idx: number) => {
        return (
          <Post key={idx} announcement={data} />
        )
      })}
    </div>
  )
}

export default AnnouncementPage