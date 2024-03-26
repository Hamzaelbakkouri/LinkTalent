export type PLAYER = {

}
export type MANAGER = {

}
export type LEADER = {

}


export type LOGIN = {

}

export enum UserTypes {
    PLAYER,
    MANAGER,
    LEADER,
    ADMIN
}

export type USERFORMAT = {
    id: string,
    firstName: string,
    lastName: string,
    address: string,
    role: string,
    email:string,
    phoneNumber: string,
}