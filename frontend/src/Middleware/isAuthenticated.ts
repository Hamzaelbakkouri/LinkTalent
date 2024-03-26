import Cookies from 'universal-cookie';


export const isAuthenticated = () => {
    const cookies = new Cookies();
    const token = cookies.get('token');
    if (token) {
        return true;
    }
    return false;
}