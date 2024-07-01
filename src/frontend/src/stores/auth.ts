import { defineStore } from 'pinia';
import { router } from '@/router';
// import { fetchWrapper } from '@/utils/helpers/fetch-wrapper';
import { post } from '@/axios';
const baseUrl = `${import.meta.env.VITE_API_URL}/api/member`;

export const useAuthStore = defineStore({
  id: 'auth',
  state: () => ({
    // initialize state from local storage to enable user to stay logged in
    /* eslint-disable-next-line @typescript-eslint/ban-ts-comment */
    // @ts-ignore
    user: JSON.parse(localStorage.getItem('user')),
    returnUrl: null
  }),
  actions: {
    async login(username: string, password: string) {
      console.log("baseURL : ", baseUrl);
      console.log("username : ", username);
      console.log("password : ", password);
      // const user = await fetchWrapper.post(`${baseUrl}/login`, { username, password });
      const user = await post(`${baseUrl}/login`, {'memberId':username, 'password':password});
      // update pinia state
      this.user = user;
      // store user details and jwt in local storage to keep user logged in between page refreshes
      localStorage.setItem('user', JSON.stringify(user));
      // redirect to previous url or default to home page
      router.push(this.returnUrl || '/dashboard/default');
    },
    logout() {
      this.user = null;
      localStorage.removeItem('user');
      router.push('/auth/login');
    }
  }
});
