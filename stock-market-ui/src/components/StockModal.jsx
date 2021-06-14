import { useState } from "react";
import { Alert, Button, Form, Modal } from "react-bootstrap";
import { post, put } from "../services/Api";

export default function StockModal({ show, onClose, data }) {
  const [name, setName] = useState("");
  const [currentPrice, setCurrentPrice] = useState("");
  const [error, setError] = useState("");
  const [isUpdate, setIsUpdate] = useState(false);
  const reset = () => {
    setName("");
    setCurrentPrice("");
    setError("");
  };
  const refresh = () => {
    setIsUpdate(data.id ? true : false);
    if (data.id) {
      setName(data.name);
      setCurrentPrice(data.currentPrice);
    }
  };
  const handleOpen = () => {
    refresh();
  };
  const handleClose = () => {
    reset();
    onClose(false);
  };
  const saveStock = async () => {
    const payload = { name, currentPrice };
    const { error } = await post("stocks", payload);
    displayError(error);
  };

  const updateStock = async () => {
    const payload = { name, currentPrice, id: data.id };
    const { error } = await put("stocks", payload);
    displayError(error);
  };

  const displayError = (error) => {
    if (!error) {
      handleClose();
    } else {
      setError(error);
    }
  };

  const displaySubmit = () => {
    return isUpdate ? (
      <Button variant="primary" onClick={updateStock}>
        Update
      </Button>
    ) : (
      <Button variant="primary" onClick={saveStock}>
        Save
      </Button>
    );
  };

  return (
    <>
      <Modal show={show} onHide={handleClose} onShow={handleOpen}>
        <Modal.Header closeButton>
          <Modal.Title>Stock Form</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Name</Form.Label>
              <Form.Control
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
              <Form.Text className="text-muted">
                Place the stock name you want to buy.
              </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
              <Form.Label>Price</Form.Label>
              <Form.Control
                type="text"
                value={currentPrice}
                onChange={(e) => setCurrentPrice(e.target.value)}
              />
            </Form.Group>
          </Form>
          {error ? <Alert variant="danger">{error}</Alert> : ""}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          {displaySubmit()}
        </Modal.Footer>
      </Modal>
    </>
  );
}
