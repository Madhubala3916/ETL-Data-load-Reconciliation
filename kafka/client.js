const { Kafka } = require("kafkajs");

exports.kafka = new Kafka({
    clientId: "my-app",
    brokers: ['192.168.200.11:9092'] // Use the correct broker format
});
