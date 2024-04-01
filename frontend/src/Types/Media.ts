import { UUID } from "crypto";

export type Media = {
    id: number;
    url: string;
    description: string;
    type: string;
    post: object;
    sport: object;
}

export type MediaRequest = {
    id?: number;
    url: string;
    description: string;
    type: string;
    post: UUID;
    sport: UUID;
}
