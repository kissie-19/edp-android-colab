package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.isPreview) {

        ProfilePreview(
            uiState = uiState,
            onBackToEdit = viewModel::backToEdit
        )

    } else {

        ProfileEdit(
            uiState = uiState,
            onNameChange = viewModel::updateName,
            onEmailChange = viewModel::updateEmail,
            onContactNumberChange = viewModel::updateContactNumber,
            onAddressChange = viewModel::updateAddress,
            onUsernameChange = viewModel::updateUsername,
            onNewSkillChange = viewModel::updateNewSkill,
            onAddSkill = viewModel::addSkill,
            onRemoveSkill = viewModel::removeSkill,
            onPreview = viewModel::showPreview
        )

    }
}

@Composable
private fun ProfileEdit(
    uiState: ProfileUiState,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onContactNumberChange: (String) -> Unit,
    onAddressChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onNewSkillChange: (String) -> Unit,
    onAddSkill: () -> Unit,
    onRemoveSkill: (String) -> Unit,
    onPreview: () -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            Text("User Profile")
        }

        item {
            OutlinedTextField(
                value = uiState.name,
                onValueChange = onNameChange,
                label = {
                    Text("Name")
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = uiState.email,
                onValueChange = onEmailChange,
                label = {
                    Text("Email")
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = uiState.contactNumber,
                onValueChange = onContactNumberChange,
                label = {
                    Text("Contact Number")
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = uiState.address,
                onValueChange = onAddressChange,
                label = {
                    Text("Address")
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = uiState.username,
                onValueChange = onUsernameChange,
                label = {
                    Text("Username")
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Text("Skills")
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                OutlinedTextField(
                    value = uiState.newSkill,
                    onValueChange = onNewSkillChange,
                    label = {
                        Text("Add a skill")
                    },
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = onAddSkill
                ) {
                    Text("Add")
                }
            }
        }

        items(uiState.skills) { skill ->

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = skill
                )

                OutlinedButton(
                    onClick = {
                        onRemoveSkill(skill)
                    }
                ) {
                    Text("Remove")
                }
            }
        }

        item {

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = onPreview,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Preview")
            }
        }
    }
}

@Composable
private fun ProfilePreview(
    uiState: ProfileUiState,
    onBackToEdit: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text("Profile Preview")

        Text("Name: ${uiState.name}")

        Text("Email: ${uiState.email}")

        Text("Contact Number: ${uiState.contactNumber}")

        Text("Address: ${uiState.address}")

        Text("Username: ${uiState.username}")

        Text("Skills:")

        uiState.skills.forEach { skill ->
            Text("• $skill")
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = onBackToEdit
        ) {
            Text("Back to Edit")
        }
    }
}