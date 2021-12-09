import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  getById(id) {
    return http.get(`/landmarks/${id}`)
  },

  getAll() {
    return http.get('/landmarks');
  },

  filter(name, category, day) {
    return http.get(`/landmarks/filter?name=${name}&category=${category}&day=${day}`)
  }

}