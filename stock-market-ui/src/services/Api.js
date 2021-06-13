import config from "../config";
const SUCCESS = 200;
const SUCCESS_NO_CONTENT = 204;

const { SERVER_URL } = config();

export async function get(resource) {
  const res = await fetch(`${SERVER_URL}/${resource}`);
  const responseBody = await res.json();
  return responseObj(responseBody, res.status, SUCCESS);
}

export async function getById(resource, id) {
  const res = await fetch(`${SERVER_URL}/${resource}/${id}`);
  const responseBody = await res.json();
  return responseObj(responseBody, res.status, SUCCESS);
}

export async function put(resource, id) {
  const res = await fetch(`${SERVER_URL}/${resource}/${id}`);
  const responseBody = await res.json();
  return responseObj(responseBody, res.status, SUCCESS_NO_CONTENT);
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
  return responseObj(responseBody, res.status, SUCCESS);
}

function responseObj(responseBody, status, result) {
  if (status !== result) {
    return {
      error: responseBody.message,
    };
  } else {
    return responseBody;
  }
}
