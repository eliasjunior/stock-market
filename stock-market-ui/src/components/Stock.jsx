import React from "react";
import { Button } from "react-bootstrap";
export default function Stock({ name, currentPrice, lastUpdate, id }) {
  const updateStock = (id) => {
    console.log(id);
  };
  return (
    <tr>
      <td>{name}</td>
      <td>{currentPrice}</td>
      <td>{lastUpdate}</td>
      <td>
        <Button onClick={() => updateStock(id)}>Update</Button>
      </td>
    </tr>
  );
}
