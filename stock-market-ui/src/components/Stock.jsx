import React from "react";
import { Button } from "react-bootstrap";
export default function Stock({ stock, onUpdate }) {
  const { name, currentPrice, lastUpdate, id} = stock;
  return (
    <tr>
      <td>{name}</td>
      <td>{currentPrice}</td>
      <td>{lastUpdate}</td>
      <td>
        <Button onClick={() => onUpdate({  name, currentPrice, id  })}>Update</Button>
      </td>
    </tr>
  );
}
