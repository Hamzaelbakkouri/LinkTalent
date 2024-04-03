'use client'
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Cookies from 'universal-cookie';
import { toast } from 'react-toastify';

interface ApplyDtoResponse {
    id: {
        announcement: any;
        player: string;
    };
    fileType: string;
    applyingDate: string;
    letter: string;
}

const UserApplications: React.FC = () => {
    const cookie = new Cookies();
    const [applications, setApplications] = useState<any[]>([]);
    const [currentPage, setCurrentPage] = useState<number>(0);
    const [totalPages, setTotalPages] = useState<number>(0);
    const userId = cookie.get('user');


    useEffect(() => {
        console.log(cookie.get("token"));

        // const fetchApplications = async () => {
        (async () => {
            try {
                await axios.get<ApplyDtoResponse[]>(
                    `http://localhost:8080/api/apply/user/${userId.id}?page=${currentPage}&size=5`, {
                    headers: {
                        Authorization: `Bearer ${cookie.get("token")}`
                    }
                }
                ).then(async (response) => {
                    // @ts-ignore
                    const aresponse = response.data.content;
                    setApplications(await aresponse);
                    setTotalPages(aresponse.headers['x-total-pages']);
                }
                )
            } catch (error) {
                console.error(error);
                toast.error('Failed to fetch applications. Please try again.');
            }
        })()
    }, []);

    const handlePageChange = (pageNumber: number) => {
        setCurrentPage(pageNumber);
    };

    return (
        <div className="w-full h-auto flex pt-9 justify-center items-center">
            <div className="bg-[#1E1F24] h-[55%] w-[50%] rounded-md py-14 px-7 border border-gray-600 flex flex-col">
                <div className="flex flex-col justify-start w-full items-center">
                    <h3 className="text-3xl font-bold uppercase text-[#45a3fce3] rounded-lg bg-[#1f2024]">User Applications</h3>
                </div>

                <div className="flex flex-col justify-center py-8">
                    {Array.isArray(applications) && applications.length > 0 ? (
                        applications.map((application, index) => (
                            <div key={index} className="relative mb-4">
                                <div className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white">
                                    <p className='text-lg'>Announcement ID: <p className='text-sm text-[#4095E4]'>{application.id.announcement.id}</p></p>
                                    <p className='text-lg'>Announcement Description:  <p className='text-sm text-[#4095E4]'>{application.id.announcement.description}</p></p>
                                    <p className='text-lg'>Applying Date: <p className='text-sm text-[#4095E4]'>{application.applyingDate}</p></p>
                                    <p className='text-lg'>Letter: <p className='text-sm text-[#4095E4]'>{application.letter} letter</p></p>
                                </div>
                            </div>
                        ))
                    ) : (
                        <p>No applications found.</p>
                    )}
                </div>

                <div className="flex justify-center">
                    <nav aria-label="Page navigation">
                        <ul className="inline-flex -space-x-px">
                            <li>
                                <button
                                    onClick={() => handlePageChange(currentPage - 1)}
                                    disabled={currentPage === 0}
                                    className="px-3 py-2 ml-0 leading-tight text-gray-500 bg-white border border-gray-300 rounded-l-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"
                                >
                                    Previous
                                </button>
                            </li>
                            {Array.from({ length: totalPages }, (_, i) => (
                                <li key={i}>
                                    <button
                                        onClick={() => handlePageChange(i)}
                                        className={`px-3 py-2 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white ${i === currentPage ? 'bg-gray-100 text-gray-700' : ''
                                            }`}
                                    >
                                        {i + 1}
                                    </button>
                                </li>
                            ))}
                            <li>
                                <button
                                    onClick={() => handlePageChange(currentPage + 1)}
                                    disabled={currentPage === totalPages - 1}
                                    className="px-3 py-2 leading-tight text-gray-500 bg-white border border-gray-300 rounded-r-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"
                                >
                                    Next
                                </button>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    );
};

export default UserApplications;