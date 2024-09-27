import endpoints from '../endpoints';
import fetcher from '../utils/fetcher';

export const getUsers = () => {
  let users = fetcher(`${endpoints}/api/user/getAll`);
  users.then(data => {
    console.log(data);
  });
  return users;
};
