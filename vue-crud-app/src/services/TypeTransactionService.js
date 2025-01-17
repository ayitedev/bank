import http from "../http-common";

class TypeTransactionService {
  getAll() {
    return http.get("/type-transaction");
  }

  get(id) {
    return http.get(`/type-transaction/${id}`);
  }

  create(data) {
    return http.post("/type-transaction", data);
  }

  update(id, data) {
    return http.put(`/type-transaction/${id}`, data);
  }

  delete(id) {
    return http.delete(`/type-transaction/${id}`);
  }

  deleteAll() {
    return http.delete(`/type-transaction`);
  }

  findByTitle(title) {
    return http.get(`/type-transaction?title=${title}`);
  }
}

export default new type-transaction();
