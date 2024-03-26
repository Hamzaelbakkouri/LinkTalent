import { USERFORMAT, UserTypes } from '@/Types/UserTypes';
import { HeroScrollDemo } from '@/components/Home/HeroHome'
import React from 'react'

const users: USERFORMAT[] = [
    {
        firstName: "John",
        lastName: "Doe",
        address: "123 Main St",
        role: UserTypes.PLAYER,
        phoneNumber: "555-555-5555",
        sport: "Basketball"
    },
    {
        firstName: "Alice",
        lastName: "Smith",
        address: "456 Elm St",
        role: UserTypes.PLAYER,
        phoneNumber: "555-123-4567",
        sport: "Soccer"
    },
    {
        firstName: "Bob",
        lastName: "Johnson",
        address: "789 Oak St",
        role: UserTypes.LEADER,
        phoneNumber: "555-987-6543",
        sport: "Tennis"
    },
    {
        firstName: "Emily",
        lastName: "Brown",
        address: "246 Pine St",
        role: UserTypes.MANAGER,
        phoneNumber: "555-222-3333",
        sport: "Swimming"
    },
    {
        firstName: "David",
        lastName: "Wilson",
        address: "135 Maple St",
        role: UserTypes.PLAYER,
        phoneNumber: "555-888-9999",
        sport: "Football"
    },
    {
        firstName: "Sophia",
        lastName: "Miller",
        address: "579 Cedar St",
        role: UserTypes.LEADER,
        phoneNumber: "555-444-7777",
        sport: "Volleyball"
    },
    {
        firstName: "James",
        lastName: "Taylor",
        address: "369 Walnut St",
        role: UserTypes.LEADER,
        phoneNumber: "555-666-1111",
        sport: "Golf"
    },
    {
        firstName: "Olivia",
        lastName: "Martinez",
        address: "802 Birch St",
        role: UserTypes.PLAYER,
        phoneNumber: "555-333-0000",
        sport: "Baseball"
    },
    {
        firstName: "William",
        lastName: "Anderson",
        address: "975 Cherry St",
        role: UserTypes.PLAYER,
        phoneNumber: "555-777-2222",
        sport: "Hockey"
    },
    {
        firstName: "Emma",
        lastName: "Garcia",
        address: "613 Pineapple St",
        role: UserTypes.MANAGER,
        phoneNumber: "555-999-8888",
        sport: "Badminton"
    }
];

const Landing = () => {
    return (
        <>
            <HeroScrollDemo people={users} />
        </>
    )
}

export default Landing
