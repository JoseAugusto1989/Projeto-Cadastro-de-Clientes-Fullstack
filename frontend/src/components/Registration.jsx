import * as React from "react";
import { useState, useEffect } from "react";

import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container } from "@mui/system";
import { Button, Paper } from "@mui/material";

const Registration = () => {
  const paperStyle = { padding: "50px 40px", width: 486, margin: "20px auto" };

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");
  const [cpf, setCpf] = useState("");
  const [occupation, setOccupation] = useState("");
  const [registration, SetRegistration] = useState([]);

  const handleClick = (e) => {
    e.preventDefault();
    const registration = { name, email, address, phone, cpf, occupation };
    console.log(registration);
    fetch("http://localhost:8090/customer/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(registration),
    }).then(() => {
      console.log("Cadastro adicionado com sucesso!");
    });
  };

  useEffect(() => {
    fetch("http://localhost:8090/customer/getAll")
      .then((resp) => resp.json())
      .then((result) => {
        SetRegistration(result);
      });
  }, []);

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <Box
          component="form"
          sx={{
            "& > :not(style)": { m: 1, width: "25ch" },
          }}
          noValidate
          autoComplete="on"
        >
          <h1 style={{ color: "black" }}>Cadastro de Clientes</h1>
          <TextField
            id="outlined-basic"
            label="Nome"
            variant="outlined"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Email"
            variant="outlined"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Telefone"
            variant="outlined"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Endereço"
            variant="outlined"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="CPF/CNPJ"
            variant="outlined"
            value={cpf}
            onChange={(e) => setCpf(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Profissão"
            variant="outlined"
            value={occupation}
            onChange={(e) => setOccupation(e.target.value)}
          />
          <Button
            variant="contained"
            onClick={handleClick}
            color="primary"
            disableElevation
          >
            Cadastrar
          </Button>
        </Box>
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        {registration.map((regist) => (
          <Paper
            elevation={6}
            style={{ margin: "10px", padding: "15px", textAlign: "left" }}
            key={regist.id}
          >
            
            Nome: {regist.name}<br />
            Endereço: {regist.address}<br />
            Telefone: {regist.phone}
          </Paper>
        ))}
      </Paper>
    </Container>
  );
};

export default Registration;
