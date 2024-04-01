import { Apply } from "./Apply";
import { team } from "./Team";

export type Announcement = {
    id : string;
    title: string;
    places: number;
    description: string;
    location: string;
    creationDate: string;
    endDate: string;
    link: string;
    team: team;
    applies: Apply[];
} 
