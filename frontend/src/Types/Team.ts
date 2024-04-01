import { sport } from "./Sport";

export type team = {
    id: string;
    name: string;
    sport: sport;
    creationDate: string;
    mainLocation: string;
}