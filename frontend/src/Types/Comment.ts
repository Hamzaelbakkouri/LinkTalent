import { UUID } from "crypto";

export type Comment = {
    id: number;
    text: string;
    creationDate: string;
    commentParent: object;
    person: object;
    post: object;
    commentReactions: object[];
    reply: object[];
}

export type CommentRequest = {
    text: string;
    commentParent: number;
    person: UUID;
    post: UUID;
}