import config from "../config";
const SUCCESS = 200;
const SUCCESS_NO_CONTENT = 204;

const { SERVER_URL } = config();

export async function get(resource) {
  const res = await fetch(`${SERVER_URL}/${resource}`);
  const responseBody = await res.json();
  return responseObj(responseBody, res.status);
}

export async function getById(resource, id) {
  const res = await fetch(`${SERVER_URL}/${resource}/${id}`);
  const responseBody = await res.json();
  return responseObj(responseBody, res.status);
}

export async function put(resource, stock) {
  const res = await fetch(`${SERVER_URL}/${resource}`, {
    method: "PUT",
    body: JSON.stringify(stock),
    headers: {
      "Content-Type": "application/json",
    },
  });
  return responseObj({}, res.status);
}

export async function post(resource, stock) {
  const res = await fetch(`${SERVER_URL}/${resource}`, {
    method: "POST",
    body: JSON.stringify(stock),
    headers: {
      "Content-Type": "application/json",
    },
  });
  const responseBody = await res.json();
  return responseObj(responseBody, res.status);
}

function responseObj(responseBody, status) {
    switch (status) {
        case SUCCESS:
            return responseBody;
        case SUCCESS_NO_CONTENT:
            return {};
        default:
            return { error: responseBody.message};
    }
}
