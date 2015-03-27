security = {
    authorize {
        authenticated "/hello/**"
    }

    loginUrl '/login'
    logoutSuccessUrl '/'
}

users = {
    inMemory {
        newUser username: 'jeff', password: 'password', roles: ['USER']
        newUser username: 'graeme', password: 'password', roles: ['USER']
        newUser username: 'lari', password: 'password', roles: ['USER']
    }
}
