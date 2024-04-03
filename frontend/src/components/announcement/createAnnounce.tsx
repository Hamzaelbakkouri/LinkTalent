'use client'
import React from 'react';
import { useForm, SubmitHandler } from 'react-hook-form';
import axios from 'axios';
import { toast } from 'react-toastify';
import Cookies from 'universal-cookie';

interface FormValues {
    title: string;
    places: number;
    description: string;
    location: string;
    creationDate: string;
    endDate: string;
    link: string;
    team: string;
}

const CreateAnnouncement: React.FC = () => {
    const cookie = new Cookies();
    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm<FormValues>();

    const onSubmit: SubmitHandler<FormValues> = async (data: FormValues) => {
        try {
            const response = await axios.post('http://localhost:8080/api/announcement', data,
                {
                    headers: {
                        Authorization: `Bearer ${cookie.get("token")}`
                    }
                }
            );
            console.log(response.data);
            toast.success('Announcement created successfully!');
        } catch (error) {
            console.error(error);
            toast.error('Failed to create announcement. Please try again.');
        }
    };

    return (
        <div className="w-full h-auto flex pt-9 justify-center items-center">
            <form onSubmit={handleSubmit(onSubmit)} className="bg-[#1E1F24] h-[55%] w-[50%] rounded-md py-14 px-7 border border-gray-600 flex flex-col">
                <div className="flex flex-col justify-start w-full items-center">
                    <h3 className="text-3xl font-bold uppercase text-[#45a3fce3] rounded-lg bg-[#1f2024]">Create Announcement</h3>
                </div>

                <div className="flex flex-col justify-center py-8">
                    <div className="relative mb-4">
                        <input
                            type="text"
                            id="title"
                            {...register('title', {
                                required: 'Title is required',
                                maxLength: { value: 80, message: 'Title is too long' },
                            })}
                            className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
                            placeholder="Title"
                        />
                        {errors.title && <small className="absolute text-red-700 pl-2">{errors.title.message}</small>}
                    </div>

                    <div className="relative mb-4">
                        <input
                            type="number"
                            id="places"
                            {...register('places', {
                                required: 'Number of places is required',
                                min: { value: 1, message: 'Number of places must be greater than 0' },
                            })}
                            className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
                            placeholder="Number of Places"
                        />
                        {errors.places && <small className="absolute text-red-700 pl-2">{errors.places.message}</small>}
                    </div>

                    <div className="relative mb-4">
                        <textarea
                            id="description"
                            {...register('description', {
                                required: 'Description is required',
                                maxLength: { value: 1000, message: 'Description is too long' },
                            })}
                            className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
                            placeholder="Description"
                        />
                        {errors.description && <small className="absolute text-red-700 pl-2">{errors.description.message}</small>}
                    </div>

                    <div className="relative mb-4">
                        <input
                            type="text"
                            id="location"
                            {...register('location', {
                                required: 'Location is required',
                                maxLength: { value: 100, message: 'Location is too long' },
                            })}
                            className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
                            placeholder="Location"
                        />
                        {errors.location && <small className="absolute text-red-700 pl-2">{errors.location.message}</small>}
                    </div>

                    <div className="relative mb-4">
                        <input
                            type="date"
                            id="creationDate"
                            {...register('creationDate', {
                                required: 'Creation date is required',
                                validate: (value) => {
                                    const today = new Date().toISOString().split('T')[0];
                                    return (
                                        value >= today || 'Creation date must be today or in the future'
                                    );
                                },
                            })}
                            className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
                        />
                        {errors.creationDate && <small className="absolute text-red-700 pl-2">{errors.creationDate.message}</small>}
                    </div>

                    <div className="relative mb-4">
                        <input
                            type="date"
                            id="endDate"
                            {...register('endDate', {
                                required: 'End date is required',
                                validate: (value) => {
                                    const today = new Date().toISOString().split('T')[0];
                                    return (
                                        value >= today || 'End date must be today or in the future'
                                    );
                                },
                            })}
                            className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
                        />
                        {errors.endDate && <small className="absolute text-red-700 pl-2">{errors.endDate.message}</small>}
                    </div>

                    <div className="relative mb-4">
                        <input
                            type="text"
                            id="link"
                            {...register('link', {
                                required: 'Link is required',
                                maxLength: { value: 200, message: 'Link is too long' },
                                pattern: {
                                    value: /^(https?:\/\/)?[\w\-]+(\.[\w\-]+)+[/#?]?.*$/,
                                    message: 'Invalid link format',
                                },
                            })}
                            className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
                            placeholder="Link"
                        />
                        {errors.link && <small className="absolute text-red-700 pl-2">{errors.link.message}</small>}
                    </div>

                    <div className="relative mb-4">
                        <input
                            type="text"
                            id="team"
                            {...register('team', {
                                required: 'Team ID is required',
                                pattern: {
                                    value: /^[\da-f]{8}-([\da-f]{4}-){3}[\da-f]{12}$/,
                                    message: 'Invalid team ID format',
                                },
                            })}
                            className="block w-full px-4 py-3 text-sm text-gray-900 border font-semibold border-gray-300 rounded-lg bg-gray-50 dark:bg-[#27292F] dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
                            placeholder="Team ID"
                        />
                        {errors.team && <small className="absolute text-red-700 pl-2">{errors.team.message}</small>}
                    </div>
                    <div className="flex justify-center">
                        <button
                            type="submit"
                            className="bg-[#45a3fce3] text-white font-semibold py-3 px-6 rounded-lg hover:bg-[#2d99ffe3]"
                        >
                            Create
                        </button>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default CreateAnnouncement;