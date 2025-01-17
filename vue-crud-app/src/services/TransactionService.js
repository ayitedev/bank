import http from "../http-common";

class transactionService {
  getAll() {
    return http.get("/transaction");
  }

  get(id) {
    return http.get(`/transaction/${id}`);
  }

  create(data) {
    return http.post("/transaction", data);
  }

  update(id, data) {
    return http.put(`/transaction/${id}`, data);
  }

  delete(id) {
    return http.delete(`/transaction/${id}`);
  }

  deleteAll() {
    return http.delete(`/transaction`);
  }

  findByTitle(title) {
    return http.get(`/transaction?title=${title}`);
  }
}

export default new transactionService();
