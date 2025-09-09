// screens/LoginScreen.tsx
import React, { useState } from "react";
import { View, Text, TextInput, Button, StyleSheet, Alert } from "react-native";
import { API_BASE } from "../config/api";

const LoginScreen: React.FC = () => {
    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");

    const handleLogin = async () => {
        try {
            const response = await fetch(`${API_BASE}/auth/login`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ username, password }),
            });

            const data = await response.json();

            if (data.success) {
                Alert.alert("Login thành công", `Chào mừng ${username}`);
            } else {
                Alert.alert("Lỗi đăng nhập", data.message || "Sai tài khoản hoặc mật khẩu");
            }
        } catch (error) {
            console.error("Lỗi:", error);
            Alert.alert("Lỗi", "Không kết nối được server");
        }
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Đăng nhập</Text>

            <TextInput
                style={styles.input}
                placeholder="Tên đăng nhập"
                value={username}
                onChangeText={setUsername}
            />

            <TextInput
                style={styles.input}
                placeholder="Mật khẩu"
                secureTextEntry
                value={password}
                onChangeText={setPassword}
            />

            <Button title="Đăng nhập" onPress={handleLogin} />
        </View>
    );
};

export default LoginScreen;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        padding: 20,
    },
    title: {
        fontSize: 24,
        marginBottom: 20,
        textAlign: "center",
    },
    input: {
        borderWidth: 1,
        borderColor: "#ccc",
        marginBottom: 15,
        padding: 10,
        borderRadius: 5,
    },
});
