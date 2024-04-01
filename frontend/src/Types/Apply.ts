export type ApplyRequest = {
    id: {
        announcement: {
            id: string
        }
        player: {
            id: string
        }
    }
    fileType: string
    letter: string
}


export type ApplyResponse = {
    id: string
    announcement: {
        id: string
        title: string
        places: number
        description: string
        location: string
        creationDate: string
        endDate: string
        link: string
        team: string
    }
    player: {
        id: string
        firstName: string
        lastName: string
        address: string
        role: string
        email: string
        phoneNumber: string
        sport: {
            id: string
            name: string
            description: string
            numberOfPlayers: number
            rules: string[]
            category: string
        }
    }
    fileType: string
    applyingDate: string
    letter: string
}
