import React from "react";
import { Table } from "react-bootstrap";
import Stock from "./Stock";

export default function StockList({ stocks }) {
  if (stocks.length === 0) {
    return <div className="loading">LOADING ...</div>;
  }
  return (
    <Table striped bordered hover responsive>
      <thead>
        <tr>
          <th>Name</th>
          <th>Price</th>
          <th>Last Update</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        {stocks.map((stock) => (
          <Stock key={stock.id} {...stock}></Stock>
        ))}
      </tbody>
    </Table>
  );
}
